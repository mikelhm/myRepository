package com.example.dataaccessdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class externalActivity extends Activity {
   
	private Button writeBut;
	private Button readBut;

	private EditText writeText;
	private TextView readText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externalread);
		writeBut = (Button) findViewById(R.id.writeBut);
		readBut = (Button) findViewById(R.id.readBut);
		writeText = (EditText) findViewById(R.id.writeText);
		readText = (TextView) findViewById(R.id.readText);
		writeText.setText("hello android");
		writeBut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				writeSDcard(writeText.getText().toString());

			}
		});
		readBut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				readText.setText(readSDcard());
			}
		});
	}

	// ������д��SD��
	private void writeSDcard(String str) {

		try {
			// �ж��Ƿ����SD��,���������ô�û�ȡSD����Ŀ¼
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				// ��ȡSD����Ŀ¼
				File file = Environment.getExternalStorageDirectory();
				FileOutputStream fileW = new FileOutputStream(file.getCanonicalPath() + "/sdtest.txt");
				fileW.write(str.getBytes());
				fileW.close();
				Toast.makeText(externalActivity.this, "�ɹ�д��SD��", Toast.LENGTH_LONG).show();  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ��SD���ж�ȡ����
	private String readSDcard() {
		StringBuffer str = new StringBuffer();
		try {
			// �ж��Ƿ����SD
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				File file = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "/sdtest.txt");                                                                
				// �ж��Ƿ���ڸ��ļ�
				if (file.exists()) {
					// ���ļ�������
					FileInputStream fileR = new FileInputStream(file);
					BufferedReader reads = new BufferedReader(new InputStreamReader(fileR));
					String st = null;
					while ((st =reads.readLine())!=null ) {
						str.append(st);
					}
					fileR.close();
					Toast.makeText(externalActivity.this, "�ɹ���ȡSD��", Toast.LENGTH_LONG).show(); 
				} else {
					readText.setText("��Ŀ¼���ļ�������");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}
}
