package pe.farmaciasperuanas.concentrador.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class Util {
	
	private Util() {}

	public static boolean isEmptyWithTrim(String character) {
		return (character == null) || (character.trim().length() == 0);
	}

	public static boolean isNotNull(Object object) {
		return (object != null);
	}

	public static LocalDateTime getCurrentLocalDateTime() {
		ZonedDateTime fecha = ZonedDateTime.now(ZoneId.systemDefault());
		return fecha.withZoneSameInstant(ZoneId.of(Constantes.TIME_ZONE)).toLocalDateTime();
	}
	
	public static String getCurrentDateTimeString() {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constantes.FORMATO_FECHA_LARGA_SERVER);
        return now.format(formatter);
	}
	
	public static <T> T objectToObject(Class<T> type, Object o) {
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			mapperObj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapperObj.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
			mapperObj.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
			String jsonString = objectToJson(o);
			return mapperObj.readValue(jsonString, type);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public static String objectToJson(Object o) {
		String jsonInString = null;
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			mapperObj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapperObj.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
			jsonInString = mapperObj.writeValueAsString(o);
		} catch (Exception e) {
			e.getMessage();
		}
		return jsonInString;
	}
	
	public static <T> List<T> listObjectToListObject(Class<T> type, Iterable<?> inList) {
		ArrayList<T> outList = new ArrayList<>();
		try {
			for (Object o : inList) {
				T t = objectToObject(type, o);
				outList.add(t);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return outList;
	}
}
