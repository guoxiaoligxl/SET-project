<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>���Ա���</title>
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
    <p style="font-size:25px;" >���Ա���----${date}</p>
    <br>
    <p>
       ���ι�����case:${count}��������FAIL:${failedNumber}��
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

