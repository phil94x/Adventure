package Brücke;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;
public class Brückenbogen {
	float ul = -14;
	float ur =  14;
	float vl = 0;
	float vr = 1;
	float ui,vj,ui1,vj1;
	int m    = 	9;
	int n    =  9;
	
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	
	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	
	float [] mat_amb = {0.33f,0.33f,0.33f,0.33f};
	float [] mat_dif = {0.33f,0.33f,0.33f,0.33f};
	float [] mat_spec = {0.33f,0.33f,0.33f,0.33f};
	private float shini = (float) 100;
	
	public void drawBrückenbogen(){
		drawFacette();
		
	}
	
	public float x(float u, float v) {
		return u ;
	}
	public float y(float u, float v) {
		return -0.043f*u*u +8.1f;
	}
	public float z(float u, float v) 
	{
		return 5.5f*v +0.5f;
	}
	
	public void drawFacette()
	{
		
	
		for(int i=0;i<m;i++) {
			
			for(int j=0; j<n;j++) {
//				glColor3f(0.5f,0.5f,0.5f);
				Normalvektor(ul + i*du,vl +j*dv);
				glBegin(GL_POLYGON);
					glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
					glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
					glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
					glMaterialf(GL_FRONT, GL_SHININESS, shini);
					glNormal3f(kp.x,kp.y,kp.z);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
				glEnd();
			}
		}
	}
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) 1;
		Xdu.y = (float) -2*0.043f*u;
		Xdu.z = (float) 0;
		
		Xdv.x = (float) 0;
		Xdv.y = (float) 0;
		Xdv.z = (float) 5.5f;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}
}
