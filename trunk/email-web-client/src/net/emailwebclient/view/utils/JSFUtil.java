package net.emailwebclient.view.utils;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

@SuppressWarnings("deprecation")
public class JSFUtil {

	public static Object getBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		Application app = context.getApplication();
		ValueBinding binding = app.createValueBinding("#{" + beanName + "}");
		Object value = binding.getValue(context);
		return value;
	}

}