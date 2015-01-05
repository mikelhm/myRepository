package com.example.dataaccessdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.util.EncodingUtils;
import org.xmlpull.v1.XmlPullParserException;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private TextView titleText;
	private TextView resultText;
	private String SDPATH=Environment.getExternalStorageDirectory()+"/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		titleText=(TextView) findViewById(R.id.titleText);
		resultText=(TextView) findViewById(R.id.resultText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater=new MenuInflater(this);//ʵ����һ��MenuInflater����
		inflater.inflate(R.menu.menu, menu);//�����˵��ļ�
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id)
		{
		case R.id.assetRead:
			String fileName = "test.txt"; //�ļ�����   
			String res="";   
			try{   
			   //�õ���Դ�е�asset������  
			   InputStream in_asset = getResources().getAssets().open(fileName);   
			   int length = in_asset.available();           
			   byte [] buffer = new byte[length];          
			   in_asset.read(buffer); 
			   in_asset.close();  
			   res = EncodingUtils.getString(buffer, "GB2312"); 
			   resultText.setText(res);
			  }catch(Exception e){   
			      e.printStackTrace();           
			   }  
			break;
		case R.id.rawRead:
			try {
				//�õ���Դ�е�Raw������  
			    InputStream in_raw = getResources().openRawResource(R.raw.rawtest);   
			    //�õ����ݵĴ�С  
			    int length;
				length = in_raw.available();
				byte [] buffer = new byte[length];          
			    //��ȡ����  
			    in_raw.read(buffer);           
			    //��test.txt�ı�������ѡ����ʵı��룬���������������   
			    res = EncodingUtils.getString(buffer, "GB2312");  
			    resultText.setText(res);
			    //�ر�      
			    in_raw.close();  
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}              
			break;
		case R.id.xmlRead:
			XmlResourceParser xrp=getResources().getXml(R.xml.customers);//����һ��xml�ļ�������
			StringBuilder sb=new StringBuilder("");//���ڱ�������stringbuilder
			try {
				while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT)//��û�ж�ȡ���ļ���ĩβ
				{
					if(xrp.getEventType()==XmlResourceParser.START_TAG)
					{
						String tagName=xrp.getName();//��ȡ�����
						if(tagName.equals("customer"))
						  {
							sb.append("����:"+xrp.getAttributeValue(0)+" ");
							sb.append("�绰:"+xrp.getAttributeValue(1)+" ");
							sb.append("�ʼ�:"+xrp.getAttributeValue(2)+" ");
							sb.append("\n");
						   }
					}
					xrp.next();
				}
				resultText.setText(sb.toString());
			} catch (XmlPullParserException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.internalRead:
			Intent intent=new Intent(MainActivity.this,internalActivity.class);
			startActivity(intent);
			break;
			
		case R.id.externalRead:
			Intent exintent=new Intent(MainActivity.this,externalActivity.class);
			startActivity(exintent);
			break;
		default:
			break;
		}//end switch
		
		return super.onOptionsItemSelected(item);
	}
	
	/*
	 * д�ļ�����
	 * �������ļ�����д�������
	 */
	public void writeSDFile(String fileName, String write_str) throws IOException{    
	        File file = new File(fileName);    
	        FileOutputStream fos = new FileOutputStream(file);    
	        byte [] bytes = write_str.getBytes();   
	        fos.write(bytes);   
	        fos.close();   
	}   
	
	 /*�ж��ļ��Ƿ��Ѿ�����*/
	  public boolean checkFileExists(String filepath) {
	         File file=new File(SDPATH+filepath);
	         return file.exists();
	    }
	  
	  /*
	   * ��SD���ϴ���Ŀ¼��
	   */
	  public File createDIR(String dirpath) {
	    File dir=new File(SDPATH+dirpath);
	    dir.mkdir();
	    return dir;
	}
	  
	  /*
	   * ��SD���ϴ����ļ���
	   */
	     public File createFile(String filepath) throws IOException{
	      File file=new File(SDPATH+filepath);
	           file.createNewFile();
	           return file;
	     }
	     
	     /*
	      * ��һ��InputStream�е�����д����SD����
	      */
	   public File writeStreamToSDCard(String dirpath,String filename,InputStream input) {
	             File file = null;
	             OutputStream output=null;
	              try {
	                  //����Ŀ¼��
	                  createDIR(dirpath);
	                  //�ڴ��� ��Ŀ¼�ϴ����ļ�
	                  file = createFile(dirpath+"/"+filename);
	                  output=new FileOutputStream(file);
	                  byte[]bt=new byte[4*1024];
	                  while (input.read(bt)!=-1) {
	                     output.write(bt);
	                  }
	                //ˢ�»��棬
	                  output.flush();
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	              finally{
	                  try{
	              output.close();
	                  }
	          catch (Exception e) {
	                     e.printStackTrace();
	                  }
	              }
	             return file;
	    }
}
