package Wasser;

import static org.lwjgl.opengl.GL11.*;
public class Umgebung {
	
	//farbe
	float rot=(139.0f/255.0f);
	float gruen=(121.0f/255.0f);
	float blau=(94.0f/255.0f);
	
	float ul = 0;
	float ur =  (float)Math.PI;
	float vl = -(float)Math.PI;
	float vr = 0;
	float count=0;
	int m    = 	25;
	int n    = 10;
	int r = 40;
	
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	
	public void drawUmgebung(){
		drawFacette();
	}
	
	public float x(float u, float v) {
		return r*(float)Math.sin(u)*(float)Math.cos(v) ;
	}
	public float y(float u, float v) {
		return r*(float)Math.sin(u)*(float)Math.sin(v) ;	
	}
	public float z(float u, float v) {
		return r*(float)Math.cos(u) ;
	}
	public void drawFacette(){
		glPolygonMode(GL_FRONT_AND_BACK,GL_FILL);
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				glColor3f(rot,gruen,blau);
				glBegin(GL_TRIANGLE_FAN );
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));				
				glEnd();
			}
		}
	}

}
