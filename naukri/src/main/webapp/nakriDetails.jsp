<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: #f0f2f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-box {
            background: white;
            padding: 30px;
            width: 450px;
            border-radius: 10px;
            box-shadow: 0px 4px 20px rgba(0,0,0,0.1);
        }

        .error {
            color: red;
            font-size: 13px;
        }

        .error-border {
            border: 2px solid red !important;
        }

        .success-border {
            border: 2px solid green !important;
        }
    </style>
</head>

<body>

<div class="form-box">

    <h3 class="text-center mb-4 text-primary">User Login</h3>




    <form action="update" method="post">


<input type="number" class="form-control" id="id" name="id" value="${info.id}" readonly>
            <div id="nameError" class="error"></div>


        <!-- Name -->
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${info.name}">
            <div id="nameError" class="error"></div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label>Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${info.email}" readonly>
            <div id="emailError" class="error"></div>
        </div>

        <!-- Mobile -->
        <div class="mb-3">
            <label>Mobile Number</label>
            <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" value="${info.mobileNumber}" readonly>
            <div id="mobileNumberError" class="error"></div>
        </div>

        <!-- Location -->
        <div class="mb-3">
            <label>Location</label>
            <input type="text" class="form-control" id="location" name="location" value="${info.location}">
            <div id="locationError" class="error"></div>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male"> Male
            <input type="radio" name="gender" value="Female"> Female
            <input type="radio" name="gender" value="Other"> Other
            <div id="genderError" class="error"></div>
        </div>

        <!-- Nationality -->
        <div class="mb-3">
            <label>Nationality</label>
            <select class="form-select" id="nationality" name="nationality">
                <option>${info.nationality}</option>
                <option>Indian</option>
                <option>South Korea</option>
                <option>Japan</option>
                <option>Canadian</option>
                <option>UK</option>
            </select>
        </div>

    </form>

    </div>
    </body>
    </html>