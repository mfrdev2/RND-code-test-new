package com.mfrdev.test.factor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Factor {
    public static <T> T loadClass(T model) throws IllegalAccessException {
        if (model == null) {
            return null;
        }

        if(model.getClass().equals(ArrayList.class)){
            return model;
        }

        for (Field decField : model.getClass().getDeclaredFields()) {
            decField.setAccessible(true);
            final Object value = decField.get(model); //data
            final String fieldName = decField.getName(); //variableName
            final Class<?> type = decField.getType(); //type of variable

            System.out.println("Value:: " + value + "   " + "  FieldName:: " + fieldName + "   Type:: " + type);

            manageData(decField, type, model, value);

        }
        return model;
    }

    private static <T> T manageData(Field decField, Class<?> type, T model, Object value) throws IllegalAccessException {
        if (String.class.equals(type)) {
            if (value == null) {
                decField.set(model, "");
            }
            return model;
        }

        if (Character.class.equals(type)) {
            if (value == null) {
                decField.set(model, "");
            }
            return model;
        }

        if (Boolean.class.equals(type)) {
            if (value == null) {
                decField.set(model, false);
            }
            return model;
        }

        if (Short.class.equals(type)) {
            if (value == null) {
                decField.set(model, 0);
            }
            return model;
        }

        if (Integer.class.equals(type)) {
            if (value == null) {
                decField.set(model, 0);
            }
            return model;
        }

        if (Float.class.equals(type)) {
            if (value == null) {
                decField.set(model, 0.0f);
            }
            return model;
        }

        if (Double.class.equals(type)) {
            if (value == null) {
                decField.set(model, 0.0);
            }
            return model;
        }


        if(short.class.equals(type)){
            return model;
        }

        if(int.class.equals(type)){
            return model;
        }

        if(float.class.equals(type)){
            return model;
        }

        if(double.class.equals(type)){
            return model;
        }

        if(char.class.equals(type)){
            return model;
        }

        if(boolean.class.equals(type)){
            return model;
        }



        if (!Object.class.equals(type)) {
            loadClass(value);
        }
        return model;
    }



    private static Object trimStringValues(Object model) {
        for (Field field : model.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(model);
                String fieldName = field.getName();

                if (value != null) {
                    if (value instanceof String) {
                        String trimmed = (String) value;
                        field.set(model, trimmed.trim());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return model;
    }

    public static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
    public static Field[] getAllFields(Class<?> cls) {
        List<Field> allFieldsList = getAllFieldsList(cls);
        return (Field[])allFieldsList.toArray(EMPTY_FIELD_ARRAY);
    }

    public static List<Field> getAllFieldsList(Class<?> cls) {
        notNull(cls, "cls", new Object[0]);
        List<Field> allFields = new ArrayList();

        for(Class<?> currentClass = cls; currentClass != null; currentClass = currentClass.getSuperclass()) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            Collections.addAll(allFields, declaredFields);
        }

        return allFields;
    }

    public static <T> T notNull(T object, String message, Object... values) {
        return Objects.requireNonNull(object, () -> {
            return String.format(message, values);
        });
    }

}