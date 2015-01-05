package com.example.dataaccessdemo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class internalActivity extends Activity {

	private Button readBut;
	private Button writeBut;
	private EditText writeText;
	private EditText readText;
	private EditText deleteText;
	private Button deleteBut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internalread);
		readBut = (Button) findViewById(R.id.read);
		writeBut = (Button) findViewById(R.id.write);
		deleteBut = (Button) findViewById(R.id.delete);
		deleteText = (EditText) findViewById(R.id.ed3);
		readText = (EditText) findViewById(R.id.ed2);
		writeText = (EditText) findViewById(R.id.ed1);
		writeText.setText("Hello android");
		deleteText.setText("datatest.txt");
		writeBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = writeText.getText().toString();//获取编辑框上的内容
				if (!str.equals("")) {//内容不为空才写进文件
					write(str);
				}

			}
		});
		readBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				read();

			}
		});
		deleteBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = deleteText.getText().toString();
				if (!str.equals("")) {
					deleteFiles(str);//传递进去一个文件名
				} else {
					deleteText.setText("文件名错误或文件不存在(请输入datatest.txt)!");
				}
			}
		});

	}

   /*
    * 向文件写入内容
    * /* 根据用户提供的文件名，以及文件的应用模式，打开一个输出流.文件不存系统会为你创建一个的， 
             * 至于为什么这个地方还有FileNotFoundException抛出，我也比较纳闷。在Context中是这样定义的 
             *   public abstract FileOutputStream openFileOutput(String name, int mode) 
             *   throws FileNotFoundException; 
             * openFileOutput(String name, int mode); 
             * 第一个参数，代表文件名称，注意这里的文件名称不能包括任何的/或者/这种分隔符，只能是文件名 
             *          该文件会被保存在/data/data/应用名称/files/
             * 第二个参数，代表文件的操作模式 
             *          MODE_PRIVATE 私有（只能创建它的应用访问） 重复写入时会文件覆盖 
             *          MODE_APPEND  私有   重复写入时会在文件的末尾进行追加，而不是覆盖掉原来的文件 
             *          MODE_WORLD_READABLE 公用  可读 
             *          MODE_WORLD_WRITEABLE 公用 可读写 
             *  
             *  */  
    
	private void write(String content) {
		try {
			// 以追加的方式打开文件输出流
			FileOutputStream fileOut = this.openFileOutput("datatest.txt",this.MODE_APPEND);
			// 写入数据
			fileOut.write(content.getBytes());//将字符串内容转换为字节
			// 关闭文件输出流
			fileOut.close();
			Toast.makeText(internalActivity.this, "成功写入", Toast.LENGTH_LONG).show();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取文件内容
	private void read() {
		try {
			readText.setText("");
			//注释掉的是另外的一种写法
			// 打开文件输入流
//			FileInputStream fileInput = this.openFileInput("datatest.txt");
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					fileInput));
//			String str = null;
//			StringBuilder stb = new StringBuilder();
//			while ((str = br.readLine()) !=null ) {
//				stb.append(str);
//			}

			FileInputStream inputStream = this.openFileInput("datatest.txt");  
            byte[] bytes = new byte[1024];  
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();  
            while (inputStream.read(bytes) != -1) {  
                arrayOutputStream.write(bytes, 0, bytes.length);  
            }  
            inputStream.close();  
            arrayOutputStream.close();  
            String content = new String(arrayOutputStream.toByteArray());  
            readText.setText(content);
			//readText.setText(stb);
			Toast.makeText(internalActivity.this, "成功读入", Toast.LENGTH_LONG).show();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//删除指定的文件
	private void deleteFiles(String fileName) {
		try {
			// 获取data文件中的所有文件列表
			List<String> names = Arrays.asList(this.fileList());
			if (names.contains(fileName)) {
				this.deleteFile(fileName);
				deleteText.setText(fileName + ":该文件成功删除！");
				Toast.makeText(internalActivity.this, "文件成功删除", Toast.LENGTH_LONG).show();  
			} else
			{
				deleteText.setText(fileName + ":该文件输入错误或不存在!");
				Toast.makeText(internalActivity.this, "删除文件出错", Toast.LENGTH_LONG).show();  
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
