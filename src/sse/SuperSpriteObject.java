package src.sse;
public class SuperSpriteObject{

    // general object properties
    private int objectType = 0; // TODO: change to an enum that includes all types of objects in a game
    public int objectType(){return objectType;}
    private int instanceID; //id unique to instance of class
    public int getInstanceID(){return instanceID;}
    private int currentActionStateID = 0; // current action state
    public int currentActionStateID(){return currentActionStateID;}
    private int actionStateFrameCount = 0; // number of frames that object has been in currentActionStateID
    private int framesAlive = 0;
    public void incFramesAlive(){framesAlive++;}
    private Boolean checkForCollision = true; //if false, collision is not calculated
    public Boolean checkForCollision(){return checkForCollision;}

    // object physical properties
    private double x_pos = 0.0;
    private double y_pos = 0.0;
    public double xPos(){return x_pos;}
    public double yPos(){return y_pos;}
    private double x_vel, y_vel;
    public double xVel(){return x_vel;}
    public double yVel(){return y_vel;}
    private double x_acc, y_acc;
    public double xAcc(){return x_acc;}
    public double yAcc(){return y_acc;}
    // object collision properties (should be its own class..?)
    private double height, width;
    public double width(){return width;}
    public double height(){return height;}

    // render options/properties
    private int zIndex; // determines rendering order
    private double zoomTransform = 1.0;
    public double getZoomTransform(){return zoomTransform;}
    private double rotateTransform = 0.0; //in radians
    public double getRotateTransform(){return rotateTransform;}
    //TODO: add optional optional rgba color overlay
    private Boolean cameraTracking = false; // flag that determines if the camera should expand to keep the object in frame
    public Boolean getCameraTracking(){return cameraTracking;}
    private Boolean skipRender = false;
    public Boolean skipRender(){return skipRender;}
    private Boolean reflect = false;
    public Boolean reflect(){return reflect;}

    // checked is used for colission detection
    private Boolean checked = false;
    public boolean collisionChecked(){return checked;}
    public void setCollisionChecked(Boolean val){checked = val;}


    // array to keep track of last n instance IDs that the object colided with
    private static int clLen = 12;
    private int[] lastCollisionInstanceIDs = new int[clLen];
    private int cli = 0;
    private Boolean idInCollisionList(int testID){ // make these public so physics can call them?
        Boolean res = false;
        for(int id : lastCollisionInstanceIDs){
            res = res || id == testID;
            if(res) return res;
        }
        return res;
    }
    private void putIDInCollisionList(int id){
        lastCollisionInstanceIDs[cli] = id;
        cli = cli + 1 % clLen;
    }


    /**********************************
    must override the following methods
    **********************************/

    // called when the object collides with another object
    public void collide(SuperSpriteObject collidingObj){
        //what happens during a collision with collidingObj? 
    }

    // called when the object may be despawned
    public Boolean despawn(){
        // under what conditions should object despawn?
        return false;
    }
    public void computeNextPos(){
        // compute position for next frame based on current coordinates, currentActionStateID, ect.
    }
    


}