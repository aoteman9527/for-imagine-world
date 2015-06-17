<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products Importer</title>
    <script
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            //add more file components if Add is clicked
            $('#addFile').click(function() {
                var fileIndex = $('#fileTable tr').children().length - 1;
                $('#fileTable').append(
                        '<tr><td>'+
                                '   <input type="file" name="files['+ fileIndex +']" />'+
                                '</td></tr>');
            });

        });
    </script>
</head>
<body>
<h1>Product Importer Multiple File Upload </h1>
<h1>File type csv</h1>

<p>Sample template file</p>
<p> <a href="<c:url value="template.csv"/>">template.csv</a></p>

<form:form method="post" action="${actionUpload}"
           modelAttribute="uploadForm" enctype="multipart/form-data">

    <p>Select files to upload. Press Add button to add more file inputs.</p>
    <input id="addFile" type="button" value="Add File" />
    <table id="fileTable">
        <tr>
            <td><input name="files[0]" type="file" /></td>
        </tr>
        <tr>
            <td><input name="files[1]" type="file" /></td>
        </tr>
    </table>
    <br/><input type="submit" value="Upload" />
</form:form>
</body>
</html>