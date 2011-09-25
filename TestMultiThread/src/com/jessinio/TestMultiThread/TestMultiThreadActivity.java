package com.jessinio.TestMultiThread;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class TestMultiThreadActivity extends Activity {
	
	Button button1;
	Button button2;
    /** Called when the activity is first created. */
	Handler mHandler;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.button1 = (Button)this.findViewById(R.id.button1);
        this.button2 = (Button)this.findViewById(R.id.button2);
     
        
        
        // 方式1: 使用Handler方式, 工作正常
//        mHandler = new Handler(){
//    		@Override
//            public void handleMessage(Message msg) {
//                // TODO Auto-generated method stub
//                super.handleMessage(msg);
//                if (msg.what==1){
//                	TestMultiThreadActivity.this.button1.setText("new Text");
//                } 
//            }
//    	};
    	
//        new Thread (){
//        	public void run(){
//        		Thread currentThread = Thread.currentThread();
//        		try {
//					// 线程停止10秒
//					currentThread.sleep(10000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        		Message msg = mHandler.obtainMessage(1, "flash");
//        		mHandler.sendMessage(msg);
//        	}
//        }.start();
//    };
        
        
        // 方式2: 如果不在UI线程上修改UI将会崩溃
//        new Thread() {
//        	public void run(){
//        		Thread currentThread = Thread.currentThread();
//        		try {
//        			// 线程停止10秒
//					currentThread.sleep(10000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        		TestMultiThreadActivity.this.button2.setText("YES");
//        	}
//        }.start();
        
        // 方式3: 使用AsyncTask类的方式
        
        ButtonTask mButtonTask = new ButtonTask(this.button2);
        // AsyncTask由execute方法开始
        mButtonTask.execute("start");
        
    }
    
    // 内部类: 实现的具体AsyncTask类
    class ButtonTask extends AsyncTask<String, Integer, Boolean> {
    	
    	Thread currentThread = Thread.currentThread();
    	Button buttonView;

    	public ButtonTask(Button buttonView){
    		this.buttonView = buttonView;
    	}
		@Override
		protected Boolean doInBackground(String... params) {
			// TODO Auto-generated method stub
			// 线程停止10秒
			try {
				currentThread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// Boolean result由doInBackground方法传入
			this.buttonView.setText("New Text");
		}
    }
}