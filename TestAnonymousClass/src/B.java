
public class B {
	private String Tag;
	
	public B(String Tag){
		this.Tag = Tag;
	}
	
	public void run(){
		// 如何让下面的匿名类产生的实例使用 infoString呢？
		
		new absA(){

			@Override
			public void beInvoke() {
				// TODO Auto-generated method stub
				System.out.println(Tag);
				System.out.println(B.this.Tag);
			}
		};
	}
	
	public void run(final String infoString){
		// 如何让下面的匿名类产生的实例使用 infoString呢？
		
		// 或者使用下面的方式： 定义一个局部变量！
		// final String interInfoString = infoString;
		new absA(){

			@Override
			public void beInvoke() {
				// TODO Auto-generated method stub
				System.out.println(infoString);
			}
		};
	}

}
