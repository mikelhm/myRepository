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
		MenuInflater inflater=new MenuInflater(this);//实例化一个MenuInflater对象
		inflater.inflate(R.menu.menu, menu);//解析菜单文件
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
			String fileName = "test.txt"; //文件名字   
			String res="";   
			try{   
			   //得到资源中的asset数据流  
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
				//得到资源中的Raw数据流  
			    InputStream in_raw = getResources().openRawResource(R.raw.rawtest);   
			    //得到数据的大小  
			    int length;
				length = in_raw.available();
				byte [] buffer = new byte[length];          
			    //读取数据  
			    in_raw.read(buffer);           
			    //依test.txt的编码类型选择合适的编码，如果不调整会乱码   
			    res = EncodingUtils.getString(buffer, "GB2312");  
			    resultText.setText(res);
			    //关闭      
			    in_raw.close();  
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}              
			break;
		case R.id.xmlRead:
			XmlResourceParser xrp=getResources().getXml(R.xml.customers);//创建一个xml文件解析器
			StringBuilder sb=new StringBuilder("");//用于保存结果的stringbuilder
			try {
				while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT)//当没有读取到文件的末尾
				{
					if(xrp.getEventType()==XmlResourceParser.START_TAG)
					{
						String tagName=xrp.getName();//获取标记名
						if(tagName.equals("customer"))
						  {
							sb.append("姓名:"+xrp.getAttributeValue(0)+" ");
							sb.append("电话:"+xrp.getAttributeValue(1)+" ");
							sb.append("邮件:"+xrp.getAttributeValue(2)+" ");
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
	 * 写文件操作
	 * 参数：文件名，写入的内容
	 */
	public void writeSDFile(String fileName, String write_str) throws IOException{    
	        File file = new File(fileName);    
	        FileOutputStream fos = new FileOutputStream(file);    
	        byte [] bytes = write_str.getBytes();   
	        fos.write(bytes);   
	        fos.close();   
	}   
	
	 /*判断文件是否已经存在*/
	  public boolean checkFileExists(String filepath) {
	         File file=new File(SDPATH+filepath);
	         return file.exists();
	    }
	  
	  /*
	   * 在SD卡上创建目录；
	   */
	  public File createDIR(String dirpath) {
	    File dir=new File(SDPATH+dirpath);
	    dir.mkdir();
	    return dir;
	}
	  
	  /*
	   * 在SD卡上创建文件；
	   */
	     public File createFile(String filepath) throws IOException{
	      File file=new File(SDPATH+filepath);
	           file.createNewFile();
	           return file;
	     }
	     
	     /*
	      * 将一个InputStream中的数据写入至SD卡中
	      */
	   public File writeStreamToSDCard(String dirpath,String filename,InputStream input) {
	             File file = null;
	             OutputStream output=null;
	              try {
	                  //创建目录；
	                  createDIR(dirpath);
	                  //在创建 的目录上创建文件
	                  file = createFile(dirpath+"/"+filename);
	                  output=new FileOutputStream(file);
	                  byte[]bt=new byte[4*1024];
	                  while (input.read(bt)!=-1) {
	                     output.write(bt);
	                  }
	                //刷新缓存，
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
