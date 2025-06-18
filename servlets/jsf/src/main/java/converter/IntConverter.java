package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "intConverter")
public class IntConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage("Не удалось преобразовать в число: " + s);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        if (obj == null) {
            return "";
        }

        if (!(obj instanceof Integer)) {
            throw new ConverterException("Значение не является целым числом: " + obj);
        }

        return String.valueOf(obj);
    }
}
