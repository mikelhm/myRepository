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
				String str = writeText.getText().toString();//��ȡ�༭���ϵ�����
				if (!str.equals("")) {//���ݲ�Ϊ�ղ�д���ļ�
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
					deleteFiles(str);//���ݽ�ȥһ���ļ���
				} else {
					deleteText.setText("�ļ���������ļ�������(������datatest.txt)!");
				}
			}
		});

	}

   /*
    * ���ļ�д������
    * /* �����û��ṩ���ļ������Լ��ļ���Ӧ��ģʽ����һ�������.�ļ�����ϵͳ��Ϊ�㴴��һ���ģ� 
             * ����Ϊʲô����ط�����FileNotFoundException�׳�����Ҳ�Ƚ����ơ���Context������������� 
             *   public abstract FileOutputStream openFileOutput(String name, int mode) 
             *   throws FileNotFoundException; 
             * openFileOutput(String name, int mode); 
             * ��һ�������������ļ����ƣ�ע��������ļ����Ʋ��ܰ����κε�/����/���ַָ�����ֻ�����ļ��� 
             *          ���ļ��ᱻ������/data/data/Ӧ������/files/
             * �ڶ��������������ļ��Ĳ���ģʽ 
             *          MODE_PRIVATE ˽�У�ֻ�ܴ�������Ӧ�÷��ʣ� �ظ�д��ʱ���ļ����� 
             *          MODE_APPEND  ˽��   �ظ�д��ʱ�����ļ���ĩβ����׷�ӣ������Ǹ��ǵ�ԭ�����ļ� 
             *          MODE_WORLD_READABLE ����  �ɶ� 
             *          MODE_WORLD_WRITEABLE ���� �ɶ�д 
             *  
             *  */  
    
	private void write(String content) {
		try {
			// ��׷�ӵķ�ʽ���ļ������
			FileOutputStream fileOut = this.openFileOutput("datatest.txt",this.MODE_APPEND);
			// д������
			fileOut.write(content.getBytes());//���ַ�������ת��Ϊ�ֽ�
			// �ر��ļ������
			fileOut.close();
			Toast.makeText(internalActivity.this, "�ɹ�д��", Toast.LENGTH_LONG).show();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ȡ�ļ�����
	private void read() {
		try {
			readText.setText("");
			//ע�͵����������һ��д��
			// ���ļ�������
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
			Toast.makeText(internalActivity.this, "�ɹ�����", Toast.LENGTH_LONG).show();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��ָ�����ļ�
	private void deleteFiles(String fileName) {
		try {
			// ��ȡdata�ļ��е������ļ��б�
			List<String> names = Arrays.asList(this.fileList());
			if (names.contains(fileName)) {
				this.deleteFile(fileName);
				deleteText.setText(fileName + ":���ļ��ɹ�ɾ����");
				Toast.makeText(internalActivity.this, "�ļ��ɹ�ɾ��", Toast.LENGTH_LONG).show();  
			} else
			{
				deleteText.setText(fileName + ":���ļ��������򲻴���!");
				Toast.makeText(internalActivity.this, "ɾ���ļ�����", Toast.LENGTH_LONG).show();  
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
