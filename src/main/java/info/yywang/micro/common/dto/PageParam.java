package info.yywang.micro.common.dto;

/**
 * @author wangyan
 * @date 2014-11-02 17:20
 */
public class PageParam {


    /**
     * 当前页码，从1开始。
     */
    private int pageIndex;

    /**
     * 每页记录数。
     */
    private int pageSize;

    /**
     * 开始条数
     */
    private int startIndex;

    /**
     * 排序字段。
     */
    private String orderBy;

    /**
     * 排序方向。
     */
    private OrderDirection orderDirection;

    /**
     * 构造函数
     */
    public PageParam(){

    }

    /**
     * 构造函数。
     * @param pageIndex 当前页码，从1开始。
     * @param pageSize 每页记录数。
     */
    public PageParam(int pageIndex,int pageSize){
        this.pageIndex=pageIndex;
        this.pageSize=pageSize;
    }



    /**
     * 构造函数。
     * @param pageIndex 当前页码，从1开始。
     * @param pageSize 每页记录数。
     * @param orderBy 排序字段
     * @param orderDirection 排序方向。
     */
    public PageParam(int pageIndex,int pageSize,String orderBy,OrderDirection orderDirection){
        this.pageIndex=pageIndex;
        this.pageSize=pageSize;
        this.orderBy=orderBy;
        this.orderDirection=orderDirection;
    }

    /**
     * 得到开始记录index。
     * @return 开始记录index。
     */
    public int getStartIndex(){
        return (pageIndex-1)*pageSize;
    }

    /**
     * @return the pageIndex
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageIndex the pageIndex to set
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the orderBy
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy the orderBy to set
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return the orderDirection
     */
    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    /**
     * @param orderDirection the orderDirection to set
     */
    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }
}
