package Wasser;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;

public class Welle2 {
	
	//farbe
	
	float ul = -14;
	float ur =  14;
	float vl = 0;
	float vr = 1;
	int m    = 	25;
	int n    =  25;
	
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	
	float count=0;
	
	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	float [] mat_amb = {0.48f,0.72f,1,1.0f};
	float [] mat_dif = {0.2f,0.48f,1,1.0f};
	float [] mat_spec = {0.57f,0.74f,1,1.0f};
	private float shini = (float) 63;
	
	public void drawWelle(){
		drawFacette();
	}
	
	public float x(float u, float v) {
		return 3*u ;
	}
	public float y(float u, float v) {
		setCount();
			return (float)Math.sin(count+u);
	}
	public float z(float u, float v) 
	{
		return 84*v ;
	}
	
	public void drawFacette()
	{
		
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
//				glColor3f(rot,gruen,blau);
				Normalvektor(ul + i*du,vl +j*dv);
				glBegin(GL_TRIANGLE_FAN );
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
					glNormal3f(-kp.x,-kp.y,-kp.z);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
				glEnd();
			}
		}
	}
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) 3;
		Xdu.y = (float) Math.cos(count+u);
		Xdu.z = (float) 0;
		
		Xdv.x = (float) 0;
		Xdv.y = (float) 0;
		Xdv.z = (float) 84;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}
	
	public void setCount() {
		if(count < 512) {
			count=count+0.000013f;
		}
		else {
			count =0;
		}
		
	}
}
