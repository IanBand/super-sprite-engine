package src.sse;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class SuperSpritePhysics {
    private ArrayList<SuperSpriteObject> scene; //enviornment (walls, floors, ceiling) will be objects for now... THIS WILL BE SET IN CONSTRUCTOR
    private int frameCount = 0;
    private double despawnLimit = 10e30; //idk what a typical value should be at all

    public void physicsLoop(){
        Iterator i = scene.iterator(), j;
        SuperSpriteObject obj, comp;

        //compute next position & despawn & uncheck colission loop
        while(i.hasNext()){
            obj = (SuperSpriteObject) i.next();

            obj.computeNextPos();
            obj.incFramesAlive();

            // reset check status to objects default
            obj.setCollisionChecked(obj.checkForCollision());

            if(obj.despawn() || autoDespawnCheck(obj)){
                i.remove();
            }
        }

        // reset iterator to start of list
        i = scene.iterator();

        //collision detection loop
        while(i.hasNext()){
            obj = (SuperSpriteObject) i.next();

            // if object has been checked, then there is no need to recheck
            if(obj.collisionChecked()){
                continue;
            }

            // mark obj as checked
            obj.setCollisionChecked(true);

            j = scene.iterator();
            while(j.hasNext()){

                comp = (SuperSpriteObject) j.next();
                // if comparison object has been checked, then there is no need to recheck
                if(comp.collisionChecked()){
                    continue;
                }
                // mark obj as checked
                comp.setCollisionChecked(true);

                // collide both objects with eachother if they have collided 
                if(detectCollision(obj, comp)){
                    comp.collide(obj);
                    obj.collide(comp);
                }
            }
        }
        // inc frame counter
        frameCount++;
    }

    private Boolean autoDespawnCheck(SuperSpriteObject obj){
        return Math.abs(obj.xPos()) >= despawnLimit || Math.abs(obj.yPos()) >= despawnLimit;
    }
        
    private Boolean detectCollision(SuperSpriteObject objA, SuperSpriteObject objB){

        // if one rectangle is on left side of other  
        //        a is to the left of b              OR        b is to the left of a 
        if(objA.xPos() + objA.width() < objB.xPos()  ||  objB.xPos() + objB.width() < objA.xPos()){
            return false;
        }

        // if one rectangle is above other  
        //              a is above b                 OR           b is above a
        if(objA.yPos() > objB.yPos() + objB.height() ||  objB.yPos() > objA.yPos() + objA.height()){
            return false;
        }

        return true;
    }
    //todo: write detectPhantomHit() here


}

