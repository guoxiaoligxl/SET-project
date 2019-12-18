<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试报告</title>
    <style>
    td{
        border: 1px solid #cc6f4a;
        text-align: center;
    }
    th{
        border: 1px solid #cc6f4a;
        text-align: center;
    }
    </style>
</head>
<body>
    <p style="font-size:25px;" >测试报告----${date}</p>
    <br>
    <p>
       本次共运行case:${count}个，其中FAIL:${failedNumber}个
    </p>   
    <table style=" border: 1px solid black; text-align: center; border-spacing: 0px;">
        <tr style="background-color:pink;">
            <th>TestName</th>
            <th>count</th>
            <th>pass</th>
            <th>failed</th>
            <th>skipped</th>
        </tr>
        <tr style="background-color:yellow;">
            <td>${testName}</td>
            <td>${count}</td>
            <td>${passNumber}</td>
            <td>${failedNumber}</td>
            <td>${skippedNumber}</td>
        </tr>
    </table>
</body>
</html>

