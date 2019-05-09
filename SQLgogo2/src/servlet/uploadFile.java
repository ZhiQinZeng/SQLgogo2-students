package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.alibaba.fastjson.JSONObject;
import dao.UserDao;

/**
 * Servlet implementation class uploadFile
 */
@WebServlet("/uploadFile")
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");

	     saveFile(request,response);
	}
	
	public void saveFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String url="/img";
		HttpSession session=request.getSession(); 
		int user_id = (int) session.getAttribute("id");
		PrintWriter out = response.getWriter();
		String savePath="";
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 返回值提示
		String message = "";
		// 创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		try {
		// 创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
		// 按照传统方式获取数据
		return ;
		}
		System.out.println("isM = "+ServletFileUpload.isMultipartContent(request));
		// 使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入
		System.out.println(request.toString());
		List<FileItem> list = upload.parseRequest(request); //上传list
		System.out.println("list:::::::::::::::::::"+list);
		for (int i=list.size()-1;i>=0;i--) {
			FileItem item = list.get(i);
		// 如果fileitem中封装的是普通输入项的数据
		if (item.isFormField()) {  //表单的其他普通文本域，如：textarea，text 文字性上传文件 不包括txt，
		String name = item.getFieldName();
		// 转码
		String value = item.getString("UTF-8");
		value = new String(value.getBytes("iso-8859-1"), "UTF-8");
		System.out.println(name + "==" + value);
			
		} else {
		// 如果fileitem中封装的是上传文件  就是如果说是上传的type = file 包括img等 类型
		//得到文件名
		String filename = item.getName();
		System.out.println("filename=" + filename);
		//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
		//filename = filename.substring(filename.lastIndexOf("\\") + 1);   //两个“\\”第一个是用来转义成->‘\’  得到filename
		System.out.println("处理后的filename"+filename);
		//获取item中的上传文件的输入流
		String type = filename.substring(filename.lastIndexOf(".") + 1);  //获取上传的格式 img？ png？
		
		InputStream in = item.getInputStream();  //这里就是将上传文件输入流写入服务器内存！！！
		//创建缓冲区
		byte buffer[] = new byte[1024];   //用来提高写入效率，否则输入成单字节输入。
		
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath1 = this.getServletContext().getRealPath("");   //得到服务器地址  保存路径
		
		System.out.println("测试服务器路劲："+savePath1);
		File file1 = new File(savePath1);
		String parfile = file1.getParent();
		
		//String realPath1 = savePath1.substring(0,savePath1.lastIndexOf("\\"));
		//String realPath = realPath1.substring(0,realPath1.lastIndexOf("\\")+1);  //得到webapp路劲
		/*String filePath = realPath +"sqlgogo_stu";
		System.out.println("filePath"+filePath);*/
		String filePath = parfile+"/sqlgogo_stu/";
		System.out.println(filePath+"filePath");
		File file = new File(filePath);
	
		//创建指针指向保存路径
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
		//System.out.println(savePath2 + "目录不存在，需要创建");
		// 创建目录
		file.mkdirs();
		}
		
		
		//创建输出流对象，用于将缓冲区的数据读出到保存路径			
//		filename=System.currentTimeMillis()+"-"+filename;  
		filename=System.currentTimeMillis() +"_"+filename;  //用时间来定义保存文件的名称
		System.out.println("filePath+filename="+filePath+filename);
		FileOutputStream output = new FileOutputStream(filePath+filename);  //用输出流打开写入目标路径
		//判断输入流中的数据是否已经读完
		int len = 0;
		//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示输入流中还有数据
		while ((len = in.read(buffer)) > 0) {
		//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
			
		output.write(buffer, 0, len);  //内存输出流，将文件从内存中真实写入服务器地址，开始写，直到缓冲区没有数据
		output.flush();  //刷新缓冲区
		}
		in.close();

		output.close();
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "done");
//		jsonObject.put("data", "http://"+request.getRemoteAddr()+":"+request.getServerPort()+"/mathhelper_upload"+url+"/"+filename);
		jsonObject.put("path",filePath +filename);
		userDao.updateProfile(user_id,"/sqlgogo_stu/" +filename);
		out.println(jsonObject.toString());
		}
		}
		}catch (FileUploadException e) {
		message = "failure";
		e.printStackTrace();
		}
		out.print(message);

}

}
