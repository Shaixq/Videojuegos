package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;


public class Main extends SimpleApplication {
    public Spatial spatial_var = null;
    public Spatial sol_spatial = null;
    public Spatial tierra_spatial = null;
    public Spatial marte_spatial = null;
    public Spatial venus_spatial = null;
    public Spatial jupiter_spatial = null;
    public Spatial saturno_spatial = null;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void simpleInitApp() {
        Node espacio = new Node("espacio");
        Sphere circulo = new Sphere(32, 32, 1); 
        Geometry sol_geom = new Geometry("sol_geom", circulo);
        Geometry tierra_geom = new Geometry("tierra_geom", circulo);
        Geometry marte_geom = new Geometry("marte_geom", circulo);
        Geometry venus_geom = new Geometry("venus_geom", circulo);
        Geometry jupiter_geom = new Geometry("jupiter_geom", circulo);
        Geometry saturno_geom = new Geometry("saturno_geom", circulo);
    
        Box cuadrado = new Box(0.5f, 0.5f, 0.5f); // Tamaño del cubo
        Geometry luna_geom = new Geometry("luna_geom", cuadrado);
        
        Material sol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sol.setColor("Color", ColorRGBA.Yellow);
        Material tierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        tierra.setColor("Color", ColorRGBA.Blue);
        Material marte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        marte.setColor("Color", ColorRGBA.Red);
        Material venus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        venus.setColor("Color", ColorRGBA.Green);
        Material jupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        jupiter.setColor("Color", ColorRGBA.Gray);
        Material saturno = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        saturno.setColor("Color", ColorRGBA.Orange);

        sol_geom.setMaterial(sol);
        tierra_geom.setMaterial(tierra);
        marte_geom.setMaterial(marte);
        venus_geom.setMaterial(venus);
        jupiter_geom.setMaterial(jupiter);
        saturno_geom.setMaterial(saturno);
    
        
        espacio.attachChild(sol_geom);
        espacio.attachChild(tierra_geom);
        espacio.attachChild(marte_geom);
        espacio.attachChild(venus_geom);
        espacio.attachChild(jupiter_geom);
        espacio.attachChild(saturno_geom);


        
        tierra_geom.move(3, 1, 0);
        tierra_geom.scale(0.5f);
        marte_geom.move(1, 1, 0);
        marte_geom.scale(0.5f);  
        venus_geom.move(-1, 3, 0);
        venus_geom.scale(0.4f);  
        jupiter_geom.move(-2, 4, 0);
        jupiter_geom.scale(0.3f);  
        saturno_geom.move(-3, 5, 0);
        saturno_geom.scale(0.7f);  

        rootNode.attachChild(espacio);
    }


    public void simpleUpdate(float tpf) {
        if(spatial_var == null){
            spatial_var = rootNode.getChild("espacio");
            sol_spatial = rootNode.getChild("sol_geom");
            tierra_spatial = rootNode.getChild("tierra_geom");
            marte_spatial = rootNode.getChild("marte_geom");
            venus_spatial = rootNode.getChild("venus_geom");
            jupiter_spatial = rootNode.getChild("jupiter_geom");
            saturno_spatial = rootNode.getChild("saturno_geom");

        }
        
        spatial_var.rotate(0, tpf/4, 0);
        sol_spatial.rotate(0, -(tpf*2), 0);
        tierra_spatial.rotate(0, tpf*4, 0);
        marte_spatial.rotate(0, tpf*8, 0);
        venus_spatial.rotate(0, tpf , 0); 
        jupiter_spatial.rotate(0, tpf * 0.5f, 0); 
        saturno_spatial.rotate(0, tpf * 0.25f, 0); 

    }


    public void simpleRender(RenderManager rm) {
    }
}
