package cn.et.demo03.mapper;

import cn.et.demo03.model.MenuModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from t_menu_info where url=#{url}")
    List<MenuModel> getMenuByUrl(String url);
}
