<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<table width="100%">
	<s:iterator var="orderItem" value="list">
	<tr>
		<td><img width="40" height="45" src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>"></td>
		<td><s:property value="#orderItem.product.pname"/></td>
		<td><s:property value="#orderItem.count"/></td>
		<td><s:property value="#orderItem.subtotal"/></td>
	</tr>
	</s:iterator>
</table>