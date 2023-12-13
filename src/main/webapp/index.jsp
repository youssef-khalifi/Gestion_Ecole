<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
    <title>School Management</title>
    <link href="https://cdn.lineicons.com/3.0/lineicons.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-12 col-lg-3">
            <div class="card">
                <div class="card-body">
                    <div class="fm-icon-box radius-15 bg-primary text-white"><i class="lni lni-home"></i>
                    </div>
                    <h5 class="my-3">Dashboard</h5>
                    <div class="fm-menu">
                        <div class="list-group list-group-flush">
                            <a href="/School_Mang_war_exploded/" class="list-group-item py-1"><i class="bi bi-house-door-fill"></i><span>Home</span></a>
                            <a href="/School_Mang_war_exploded/Home" class="list-group-item py-1"><i class="bi bi-journal-plus"></i><span>Filiere</span></a>
                            <a href="/School_Mang_war_exploded/Etudiant" class="list-group-item py-1"><i class="bi bi-people-fill"></i><span>Etudiant</span></a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-12 col-lg-9">
            <div class="card">
                <div class="card-body">
                    <div class="fm-search">
                        <div class="mb-0">
                            <div class="input-group input-group-lg">	<span class="input-group-text bg-transparent"><i class="fa fa-search"></i></span>
                                <input type="text" class="form-control" placeholder="Search ...">
                            </div>
                        </div>
                    </div>
                    <br><br>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
