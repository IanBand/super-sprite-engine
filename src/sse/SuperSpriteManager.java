package src.sse;
public class SuperSpriteManager{

    /* SuperSpriteManager is in charge of:

    - managing physics engine object
    - loading new scenes FROM JSON PLS *scenes are an ArrayList of SSObjects, including background + terrain
    - enforce hardcoded object limit? just use array then?
    - manage spawning new SSObjects, pass object spawning method to SSObjects
    - ordered insert objects into scene based on their Z-index
    - managing render object
    - manage keeping some objects loaded between scenes
    - make sure all objects have unique instanceIDs
    
    - registering player input objects with SSObjects?


    SSObject inheritance tree:

        |SSObject
            -|SSEffect (no physics/colision)
            -|SSTerrain (wall/floor/ceiling)
            -|SSBody (group of bones, position relative to body, only body colides with terrain)
            -|SSBone (needs body parent, only collides with bones in other groups & SSimpleObjects, only has position which is relative to parent body)
            -|SSimpleObject (1 sprite, collides with any bone..?, has physics) (use for simple enimes)

    SuperSpriteRender
    - loading sprites associated with current object set
    - camera coordinate transformation
    - calling render

    */
}