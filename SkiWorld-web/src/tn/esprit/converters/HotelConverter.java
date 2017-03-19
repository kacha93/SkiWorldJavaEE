package tn.esprit.converters;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.beans.HotelBean;
import tn.esprit.beans.HotelRoomBean;
import tn.esprit.entities.Hotel;

@FacesConverter(value="HotelConverter")
public class HotelConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent arg1, String hotelId) {
		ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{hotelBean}", HotelBean.class);

        HotelBean hotel = (HotelBean)vex.getValue(ctx.getELContext());
        return hotel.getEjb().findById(Integer.valueOf(hotelId));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object hotel) {
		if(hotel == null){
			return null;
		}
		if (hotel instanceof Hotel){
		Hotel o = (Hotel) hotel;
		return String.valueOf(o.getId());
		}
		return null;
	}

}
