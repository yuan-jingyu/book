package com.yuanjingyu.dto;

public class Page {

    //        1.是否有上一页(名字不要起带is开头的，会导致数据丢失)
    private Boolean hasPre;
    //        2.是否有上一页
    private Boolean hasNext;
    //        3.当前页
    private Integer pageNo;
    //        4.页容量
    private Integer pageSize;
    //        5.总记录数据
    private Long count;
    //        6.总页数
    private Integer pageCount;
    //        7.当前页数据
    private Object page;

    public Boolean getHasPre() {
        return hasPre;
    }

    public void setHasPre(Boolean hasPre) {
        this.hasPre = hasPre;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "hasPre=" + hasPre +
                ", hasNext=" + hasNext +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", pageCount=" + pageCount +
                ", page=" + page +
                '}';
    }
}
