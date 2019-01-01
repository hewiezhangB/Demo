<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookType"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%List<BookInfo> rxBooks = (List<BookInfo>)request.getAttribute("rxBooks"); %>
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	所有商品分类
            </div>
            <%
            TreeMap<BookType,List<BookType>>  bookTypes =(TreeMap<BookType,List<BookType>>)request.getAttribute("bookTypes");
            Set<BookType> parents = bookTypes.keySet();
            for(BookType bookType : parents){
            	List<BookType> son = bookTypes.get(bookType);%>
            <div class="middle_left1con">
                <div class="l2">
                    <img src="images/icon.jpg" /><%=bookType.getBookTypeName() %>
                </div>
                <%
                for(BookType sons : son){%>
                	<div class="l3">
                   &nbsp;&nbsp;<a href="<%=request.getContextPath()%>/BookListByBookTypeServlet?bookTypeId=<%=sons.getBookTypeId()%>"><%=sons.getBookTypeName() %></a><br />
                </div>
                <%}%>
            </div>
            <%}
            %>
            <div class="zzzz">
            
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">最新排行</h3>
        	<%for(BookInfo bookInfo : rxBooks){%>
        	<a href="<%=request.getContextPath() %>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId() %>"><%=bookInfo.getBookName() %></a>	
        	<%} %>
        </div> 
        <div class="middle_left2">
        	<img src="images/1.jpg">
        </div>
        <div class="middle_left2">
            <img src="images/2.jpg">
        </div>
         <div class="middle_left2">
            <img src="images/3.jpg">
         </div>
        
        
              
    </div>
