package springbootjackson.vo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
//序列化、反序列化忽略的属性，多个时用“,”隔开
//@JsonIgnoreProperties({"captcha"})
//当属性的值为空（null或者""）时，不进行序列化，可以减少数据传输
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserVoByJson {

    // 序列化、反序列化时，属性的名称
 //   @JsonProperty("userName")
    private String username;

    // 为反序列化期间要接受的属性定义一个或多个替代名称，可以与@JsonProperty一起使用
   // @JsonAlias({"pass_word", "passWord"})
 //   @JsonProperty("pwd")
    private String password;

    //序列化、反序列化时，格式化时间
   // @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    //序列化、反序列化忽略属性
  //  @JsonIgnore
    private String captcha;


    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            //当属性的值为空（null或者""）时，不进行序列化，可以减少数据传输
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

            //设置日期格式
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

            //1、Java对象转Json字符串
            UserVoByJson userVo = new UserVoByJson();
            userVo.setUsername("张三");
            userVo.setPassword("666");

            String jsonString = mapper.writeValueAsString(userVo);
            System.out.println(jsonString);

            //2、Json字符串转Java对象
            jsonString = "{\"username\":\"张三\",\"password\":\"666\",\"createDate\":\"2019-08-05 11:34:31\"}";
            UserVoByJson userVo1 = mapper.readValue(jsonString, UserVoByJson.class);
            System.out.println(userVo1);

            //3、Java对象类型转换
            HashMap<Object, Object> map = new HashMap<>();
            map.put("username", "张三");
            UserVoByJson userVo2 = mapper.convertValue(map, UserVoByJson.class);
            System.out.println(userVo2);

            //4、将json字符串转换成List
            String listJsonString = "[{\"username\":\"张三\"},{\"username\":\"李四\"}]";
            List<UserVoByJson> userVoList = mapper.readValue(listJsonString, mapper.getTypeFactory().constructParametricType(List.class, UserVoByJson.class));
            System.out.println(userVoList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
