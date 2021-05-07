package com.jetco.core.basic.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jetco.core.basic.bean.AbstractTreeNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织树形结构工具类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2019-10-12
 */
public class TreeUtils {

    private TreeUtils() {}

    /**
     * 将[{pid:'0',id:'1'},{pid:null,id:'0'}]结构的树节点转换成 {id:'0',children:[id:'1']}结构
     * @param trees 树集合
     * @param parenIdName 父ID名称
     * @param idName ID名称
     * @return treeList
     */
    public static List<Map<String,Object>> convertTreeStruct(List<Map<String,Object>> trees, String parenIdName , String idName) {
        if(trees == null || trees.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashMap<String,Map<String, Object>> nodeMap = Maps.newLinkedHashMap();
        trees.forEach(map -> {
            map.put("children", Collections.emptyList());
            nodeMap.put(map.get(idName).toString(), map);
        });
        trees.forEach(map -> {
            if(map.get(parenIdName) != null) {
                String pid = map.get(parenIdName).toString();
                if(nodeMap.containsKey(pid)) {
                    List<Map<String,Object>> children = (List<Map<String, Object>>) nodeMap.get(pid).get("children");
                    children.add(map);
                }
            }
        });
        List<Map<String,Object>> result = Lists.newArrayList();
        nodeMap.forEach((key, value) -> {
            //收集根节点
            if (value.get(parenIdName) == null) {
                result.add(nodeMap.get(key));
            }
        });
        return result;
    }

    /**
     * 将[{pid:'0',id:'1'},{pid:null,id:'0'}]结构的树节点转换成 {id:'0',children:[id:'1']}结构
     * @param trees 树集合
     * @return treeList
     */
    public static List<? extends AbstractTreeNode> convertTreeStruct(List<? extends AbstractTreeNode> trees) {
        if(trees==null||trees.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashMap<String, AbstractTreeNode> nodeMap = Maps.newLinkedHashMap();
        trees.forEach(workerNode ->
                nodeMap.put(workerNode.getId(), workerNode)
        );
        trees.forEach(workerNode -> {
            if(workerNode.getParentId() != null) {
                String pid = workerNode.getParentId();
                if(nodeMap.containsKey(pid)) {
                    List<AbstractTreeNode> children = (List<AbstractTreeNode>) nodeMap.get(pid).getChildren();
                    children.add(workerNode);
                }
            }
        });
        List<AbstractTreeNode> result = Lists.newArrayList();
        nodeMap.forEach((key, value) -> {
            //收集根节点
            if (value.getParentId() == null) {
                result.add(nodeMap.get(key));
            }
        });
        return result;
    }

    public static List<Map<String, Object>> createTree(List<Map<String, Object>> data, String key) {
        if(CollectionUtils.isEmpty(data)) {
            return Collections.emptyList();
        } else {
            //将集合中所有数据按照父Id进行分组，放入Map中，Map<parntId, List<Child>>
            Map groupByParentIdMap = data.stream().collect(Collectors.groupingBy((item) -> {
                return item.get(key) != null?item.get(key).toString():"nonParent";
            }));
            //将集合中所有数据以数据Id为key，放入Map中，Map<id, Map<String,Object>>
            Map dataMap = data.stream().collect(Collectors.toMap((item) -> {
                return item.get("id").toString();
            }, (t2) -> {
                return t2;
            }));
            List<Map<String, Object>> resp = Lists.newArrayList();
            //遍历数据，将子节点放入对应父节点Children属性中
            groupByParentIdMap.keySet().forEach((parentId) -> {
                if(dataMap.containsKey(parentId)) {
                    Object child = ((Map)dataMap.get(parentId)).get("children");
                    if(CollectionUtils.isEmpty((Collection)child)) {
                        child = Lists.newArrayList();
                        ((Map)dataMap.get(parentId)).put("children", child);
                    }

                    ((List)child).addAll((Collection)groupByParentIdMap.get(parentId));
                } else {
                    resp.addAll((Collection)groupByParentIdMap.get(parentId));
                }

            });
            return resp;
        }
    }

    public static <T extends AbstractTreeNode> List<T> createTree(List<T> data) {
        if(CollectionUtils.isEmpty(data)) {
            return Collections.emptyList();
        } else {
            //将集合中所有数据按照父Id进行分组，放入Map中，Map<parntId, List<Child>>
            Map groupByParentIdMap = data.stream().collect(Collectors.groupingBy((item) -> {
                return item.getParentId() != null?item.getParentId():"nonParent";
            }));
            //将集合中所有数据以数据Id为key，放入Map中，Map<id,T>
            Map<String, Object> dataMap = data.stream().collect(Collectors.toMap(AbstractTreeNode::getId, (t2) -> {
                return t2;
            }));
            List resp = Lists.newArrayList();
            //遍历数据，将子节点放入对应父节点Children属性中
            groupByParentIdMap.keySet().forEach((parentId) -> {
                if(dataMap.containsKey(parentId)) {
                    Object child = ((AbstractTreeNode)dataMap.get(parentId)).getChildren();
                    if(CollectionUtils.isEmpty((Collection)child)) {
                        child = Lists.newArrayList();
                    }

                    ((List)child).addAll((Collection)groupByParentIdMap.get(parentId));
                    ((AbstractTreeNode)dataMap.get(parentId)).setChildren((List)child);
                } else {
                    resp.addAll((Collection)groupByParentIdMap.get(parentId));
                }

            });
            return resp;
        }
    }

    /**
     * 把列表转换为树结构
     *
     * @param originalList 原始list数据
     * @param keyName 作为唯一标示的字段名称
     * @return 组装后的集合
     */
    public static <T> List<T> convertTree(List<T> originalList, String keyName) throws Exception {
        String parentFieldName = "parentId";
        String childrenFieldName = "children";
        // 获取根节点，即找出父节点为空的对象
        List<T> topList = new ArrayList<>();
        for (T t : originalList) {
            String parentId = BeanUtils.getProperty(t, parentFieldName);
            if (StringUtils.isBlank(parentId)) {
                topList.add(t);
            }
        }
        // 递归封装树
        fillTree(topList, originalList, keyName, parentFieldName, childrenFieldName);
        return topList;
    }

    /**
     * 封装树
     *
     * @param parentList 要封装为树的父对象集合
     * @param originalList 原始list数据
     * @param keyName 作为唯一标示的字段名称
     * @param parentFieldName 模型中作为parent字段名称
     * @param childrenFieldName 模型中作为children的字段名称
     */
    public static <T> void fillTree(List<T> parentList, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
        for (int i = 0; i < parentList.size(); i++) {
            List<T> children = fillChildren(parentList.get(i), originalList, keyName, parentFieldName, childrenFieldName);
            if (children.isEmpty()) {
                continue;
            }
            originalList.removeAll(children);
            fillTree(children, originalList, keyName, parentFieldName, childrenFieldName);
        }
    }

    /**
     * 封装子对象
     *
     * @param parent 父对象
     * @param originalList 待处理对象集合
     * @param keyName 作为唯一标示的字段名称
     * @param parentFieldName 模型中作为parent字段名称
     * @param childrenFieldName 模型中作为children的字段名称
     */
    public static <T> List<T> fillChildren(T parent, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
        List<T> childList = new ArrayList<>();
        String parentId = BeanUtils.getProperty(parent, keyName);
        for (T t : originalList) {
            String childParentId = BeanUtils.getProperty(t, parentFieldName);
            if (parentId.equals(childParentId)) {
                childList.add(t);
            }
        }
        if (!childList.isEmpty()) {
            FieldUtils.writeDeclaredField(parent, childrenFieldName, childList, true);
        }
        return childList;
    }
}
