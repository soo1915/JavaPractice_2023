package command;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;

public class ControllerUsingURI extends HttpServlet {

	ApplicationContext ctx ;
	
    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, String> commandHandlerMap = 
    		new HashMap<>();
    //init은 무조건 실행(한 번만)
    public void init() throws ServletException {
    	ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    	
    	// "configFile"을 xml 파일에서 읽어옴
        String configFile = getInitParameter("configFile");
        //System.out.println(configFile);
        Properties prop = new Properties();
        String configFilePath = getServletContext().getRealPath(configFile);
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            commandHandlerMap.put(command, handlerClassName);
//            try {
//            	// 클래스 이름이 들어있음
//                Class<?> handlerClass = Class.forName(handlerClassName);
//                CommandHandler handlerInstance = 
//                        (CommandHandler) handlerClass.newInstance();
//                commandHandlerMap.put(command, handlerInstance);
//            } catch (ClassNotFoundException | InstantiationException 
//            		| IllegalAccessException e) {
//                throw new ServletException(e);
//            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		System.out.println(command);
//        CommandHandler handler = commandHandlerMap.get(command);
//        if (handler == null) {
//            handler = new NullHandler();
//        }
		String handler = commandHandlerMap.get(command);
		//System.out.println(handler);
		// 다형성!!!
		CommandHandler helloHandler = ctx.getBean(handler, CommandHandler.class);
		// 다형성 적용 안 하고 원래대로 쓴다면?
//		HelloHandler helloHandler = ctx.getBean(handler, HelloHandler.class);
        String viewPage = null;
        try {
            viewPage = helloHandler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}