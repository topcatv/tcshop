package com.tcshop.service;

import com.tcshop.entity.CategoryTree;
import com.tcshop.mapper.CategoryMapper;
import com.tcshop.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * Category服务对象实现类
 */
@Service
@Transactional
public class CategoryService extends BaseService<Category> {
	public static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryMapper categoryMapper;

	public void update(Integer id, Category category) {
		category.setId(id);
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	public List<CategoryTree> loadCategoryTree(Integer rootId){
		Condition condition = new Condition(Category.class);
		if(rootId!=null){
			condition.createCriteria().andEqualTo("parentId",rootId);
		}else{
			condition.createCriteria().andIsNull("parentId");
		}

		condition.setOrderByClause("POSITION ASC");
		categoryMapper.selectByExample(condition);
		List<Category> list = new ArrayList<>();
		List<CategoryTree> result = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for(Category category:list){
				CategoryTree categoryTree = new CategoryTree();
				categoryTree.setLabel(category.getName());
				categoryTree.setKey(category.getId());
				categoryTree.setValue(category.getId());
				List<CategoryTree> cList = loadCategoryTree(category.getParentId());
				if(cList!=null&&cList.size()>0){
					categoryTree.setChildren(cList);
				}
				result.add(categoryTree);
			}
			return result;
		}
		return null;
	}
}
