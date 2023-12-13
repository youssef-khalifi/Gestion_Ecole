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
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-xl-6 col-lg-8 col-sm-10">
            <h2 class="font-weight-bold">Ajouter Filiere</h2>
        </div>
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="Filiere/save" method="post">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">ID</label>
                        <input type="number" name="id" value="${filiereBean.filiere.id}" class="form-control" id="exampleFormControlInput1" placeholder="" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="code" class="form-label">Code</label>
                        <input type="text" name="code"  value="${filiereBean.filiere.code}" class="form-control" id="code" placeholder="Entrer le Code du Filiere">
                    </div>
                    <div class="mb-3">
                        <label for="libelle" class="form-label">Libelle</label>
                        <input type="text" name="libelle" value="${filiereBean.filiere.libelle}"  class="form-control" id="libelle" placeholder="Entrer le Libelle du Filiere">
                    </div>
                        <input type="submit" class="btn btn-secondary" value="${filiereBean.label}">
                    </form>
                </div>
            </div>

        </div>
    </div>

    <div class="container">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h5 class="card-title">Filieres<span class="text-muted fw-normal ms-2"></span></h5>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="">
                <div class="table-responsive">
                    <table class="table project-list-table table-nowrap align-middle table-borderless">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Code</th>
                            <th scope="col">Libelle</th>
                            <th scope="col" style="width: 200px;">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                    <c:forEach items="${filiereBean.filieres}" var="f">
                        <tr>
                            <td>${f.id}</td>
                            <td>${f.code}</td>
                            <td>${f.libelle}</td>
                            <td>
                                <ul class="list-inline mb-0">
                                    <li class="list-inline-item">
                                        <a  href="Filiere/modify?id=${f.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit" class="px-2 text-primary"><i class="bx bx-pencil font-size-18"></i></a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="Filiere/delete?id=${f.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" class="px-2 text-danger"><i class="bx bx-trash-alt font-size-18"></i></a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="row g-0 align-items-center pb-4">
        <div class="col-sm-6">
            <div><p class="mb-sm-0">  Nombre total des filieres est : ${filiereBean.filieres.size()}</p></div>
        </div>
    </div>
</div>
</div>
</body>
</html>

