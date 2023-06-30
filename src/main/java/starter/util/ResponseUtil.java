package starter.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
public class ResponseUtil {
    private static final Gson jsonConverter = new Gson();

    private ResponseUtil() {
    }


    public static String getResponseMessage() {
        return getResponse().extract().response().asString();
    }

    public static int getStatusCode() {
        return getResponse().extract().statusCode();
    }

    public static ValidatableResponse getResponse() {
        return SerenityRest.then();
    }

    public static String getContentType() {
        return getResponse().extract().header("Content-Type");
    }

    public static String getResponseAsString() {
        Response response;
        try {
            response = SerenityRest.then().extract().response();
        } catch (IllegalStateException exc) {
            throw new IllegalStateException(
                    "The response can not be converted to the model");
        }
        assertThat("Response is null", response,
                is(CoreMatchers.notNullValue()));
        assertThat("Response is empty", response.asString(),
                not(isEmptyOrNullString()));
        return response.asString();
    }

    public static <T> T getModelFromResponse(Class<T> clazz) {
        return getModelFromResponse(ResponseUtil.getResponseAsString(), clazz);
    }

    public static <T> T getModelFromResponse(String jsonMessage, Class<T> clazz) {
        return getModelFromStringMessage(jsonMessage, clazz);
    }

    private static <T> T getModelFromStringMessage(String jsonMessage, Class<T> clazz) {
        T model;
        try {
            model = jsonConverter.fromJson(jsonMessage, clazz);
        } catch (Exception exc) {
            throw new IllegalStateException("Response: " + jsonMessage
                    + " can't be converted to the model. Error message: " + exc.getMessage());
        }
        return model;
    }

    public static <T> ResponseModel<T> getResponse(String jsonMessage, final Class<T> dataClass) {
        try {
            return jsonConverter.fromJson(jsonMessage, getType(ResponseModel.class, dataClass));
        } catch (Exception exc) {
            throw new IllegalStateException("Response : " + jsonMessage
                    + " can't be converted to the model. Error message: " + exc.getMessage());
        }
    }

    private static Type getType(final Class<?> rawClass, final Class<?> parameterClass) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{parameterClass};
            }

            @Override
            public Type getRawType() {
                return rawClass;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
