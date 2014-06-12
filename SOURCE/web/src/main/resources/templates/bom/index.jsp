
<%--
  - Author(s):
  - Date:
  - Copyright Notice:
  - @(#)
  - Description:
  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Tag Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
	<%--<script type="text/javascript" src="js/uploading.js"></script>--%>
	<script type="text/javascript" src="js/BaseFileUpload.js"></script>
</head>

<body>
<h1 class="text-center">New Product</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form">
                <div class="form-group">
                    <label for="code">Code </label><input type="text" class="form-control" id="code">
                </div>
				<div class="form-group">
					 <label for="name">Name</label><input type="email" class="form-control" id="name">
				</div>
				<div class="form-group">
					 <label for="price">Price </label>
                     <div class="input-group">
                         <span class="input-group-addon">$</span>
                         <input type="text" class="form-control" id="price">
                         <span class="input-group-addon">.00</span>
                     </div>
				</div>

                <div class="form-group">
                    <label for="description">Description </label> <textarea class="form-control" name="description" id="description" rows="10"></textarea>
                </div>

                <div class="form-group">
                    <label for="amount">Amount </label>
                    <div class="input-group">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown">Select <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li class="divider"></li>
                                <li><a href="#">1000</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                        <input id="amount" type="text" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="exampleInputFile">Images upload</label>
                    <div class="input-group">
                        <input id="exampleInputFile" type="file" title="Browse ... " class="btn btn-default" style="left: -141.5px; top: 2px;">
                    </div>
                    <p class="help-block">
                        Example block-level help text here.
                    </p>
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
			</form>

		</div>
	</div>
</div>
</body>
<footer>
<script>
    $(document).ready(function(){
//        $('input[type=file]').on('change', prepareUpload);
//        $('form').on('submit', uploadFiles);
        $('input[type=file]').bootstrapFileInput();
        $('.file-inputs').bootstrapFileInput();
        
    });
</script>
</footer>
</html>
