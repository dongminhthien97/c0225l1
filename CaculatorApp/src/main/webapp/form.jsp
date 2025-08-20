<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/form" method="post">
    <fieldset>
        <legend>Calculator</legend>
        First operand: <input type="text" name="firstOperand"><br><br>
        Operator:
        <select name="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select><br><br>
        Second operand: <input type="text" name="secondOperand"><br><br>
        <input type="submit" value="Calculate">
        <p>${result}</p>
    </fieldset>
</form>
</body>
</html>
