package Brücke;

import static org.lwjgl.opengl.GL11.*;

public class SteinBrücke {
	
	public float breite=2;
	public float höhe=1;
	public float facettebreite=3;
	public float facettehöhe=3;
	
	Facette facette = new Facette();
	
	public void drawStein() {
		
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			glTranslatef(0,-1,0);
			glRotatef(-90,1,0,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);				//Deckel
		glPopMatrix();
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			glTranslatef(0,0,1);
			glRotatef(90,1,0,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);				//Boden
		glPopMatrix();
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			glTranslatef(0,0,1);
			glRotatef(180,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);				//Rückseite
		glPopMatrix();
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			glTranslatef(0,0,breite*0.25f);
			glScalef(1,1,0.5f);
			glRotatef(-90,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);					// Linke Seite	
		glPopMatrix();
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			glTranslatef(0,0,breite*0.25f);
			glScalef(1,1,0.5f);
			glRotatef(90,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);				//Rechte Seite
		glPopMatrix();
		glPushMatrix();
			glTranslatef(höhe,breite*0.5f,0);
			facette.drawFacetteRechteck(facettebreite,facettehöhe,breite,höhe);				//Vorderseite
		glPopMatrix();
		
		
	}

}
