<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mail</title>
</head>
<body>
    <h4>Result:</h4>
    <hr>
        <li>自动化测试报告</li>
        <br>
        <li>本次共运行自动化case：${all}，其中FAIL:${fail}个</li>
    <table border="1" cellpadding="0" cellspacing="0"  width="800" height="100" bordercolor="black" bgcolor="">
<tr bgcolor="yellow">
        <th>all</th>
        <th>pass</th>
        <th>fail</th>
        <th>skip</th>
    </tr>
     <tr>
        <td style="text-align:center;">${all}</td>
        <td style="text-align:center;">${pass}</td>
        <td style="text-align:center;">${fail}</td>
        <td style="text-align:center;">${skip}</td>
    </tr>
    </table>
</body>
</html>