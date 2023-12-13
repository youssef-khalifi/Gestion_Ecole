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
            <h2 class="font-weight-bold">Ajouter Etudiant</h2>
        </div>

        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="Etudiants/save" method="post">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">ID</label>
                            <input type="number" name="id" value="${etudiantBean.etudiant.id}" class="form-control" id="exampleFormControlInput1" placeholder="" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="nom" class="form-label">Nom</label>
                            <input type="text" name="nom"  value="${etudiantBean.etudiant.nom}" class="form-control" id="nom" placeholder="Entrer le Nom ">
                        </div>
                        <div class="mb-3">
                            <label for="prenom" class="form-label">Prenom</label>
                            <input type="text" name="prenom" value="${etudiantBean.etudiant.prenom}"  class="form-control" id="prenom" placeholder="Entrer le Prenom">
                        </div>
                        <div class="mb-3">
                            <label for="cne" class="form-label">CNE</label>
                            <input type="text" name="cne" value="${etudiantBean.etudiant.cne}"  class="form-control" id="cne" placeholder="Entrer le CNE">
                        </div>
                        <div class="mb-3">
                            <label  class="form-label">Filiere</label>
                            <select name="filiere" class="form-control" aria-label="Default select example" >
                                <option value="${etudiantBean.etudiant.filiere.code}">${etudiantBean.etudiant.filiere.code}</option>
                                <c:forEach items="${etudiantBean.filieres}" var="e">
                                    <option value="${e.code}">${e.code}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" class="btn btn-secondary" value="${etudiantBean.label}">
                    </form>
                </div>
            </div>

        </div>
    </div>


    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6">
                <div class="mb-3">
                    <h5 class="card-title">Etudiants<span class="text-muted fw-normal ms-2"></span></h5>
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
                                <th scope="col">Nom</th>
                                <th scope="col">Prenom</th>
                                <th scope="col">CNE</th>
                                <th scope="col">Filiere</th>
                                <th scope="col" style="width: 200px;">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${etudiantBean.etudiants}" var="e">
                                <tr>
                                    <td>${e.id}</td>
                                    <td>${e.nom}</td>
                                    <td>${e.prenom}</td>
                                    <td>${e.cne}</td>
                                    <td>${e.filiere.code}</td>
                                    <td>
                                        <ul class="list-inline mb-0">
                                            <li class="list-inline-item">
                                                <a  href="Etudiants/modify?id=${e.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit" class="px-2 text-primary"><i class="bx bx-pencil font-size-18"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href="Etudiants/delete?id=${e.id}" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete" class="px-2 text-danger"><i class="bx bx-trash-alt font-size-18"></i></a>
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
                <div><p class="mb-sm-0">  Nombre total des etudiants est : ${etudiantBean.etudiants.size()}</p></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

