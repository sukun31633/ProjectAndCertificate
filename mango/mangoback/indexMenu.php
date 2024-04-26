<?php 
    require_once('connection.php');

    if (isset($_REQUEST['delete_id'])) {
        $id = $_REQUEST['delete_id'];

        $select_stmt = $db->prepare("SELECT * FROM menu WHERE id = :id");
        $select_stmt->bindParam(':id', $id);
        $select_stmt->execute();
        $row = $select_stmt->fetch(PDO::FETCH_ASSOC);

        // Delete an original record from db
        $delete_stmt = $db->prepare('DELETE FROM menu WHERE id = :id');
        $delete_stmt->bindParam(':id', $id);
        $delete_stmt->execute();

        header('Location:indexMenu.php');
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="css/back-end.css">
</head>
<body>

    <nav>
        <div class="nav-container">
            <div class="logonav">
                <img src="logo.png" >
                <a href="#" class="logo"><span class="name">การจัดการข้อมูล</span></a> 
            </div> 
            <div class="navber">
                <a href="indexMenu.php"><br>Menu</a>
                <a href="indexData.php"><br>Data</a>  
            </div>
        </div>
    </nav>

    <div class="container alot">
    <div class="display-3 text-center">Update Menu Page</div>
    <a href="addMenu.php" class="btn btn-success mb-3">Add Menu</a>
    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Menu name</th>
                <th>Image</th>
                <th>Ingredient</th>
                <th>Step</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <?php 
                $select_stmt = $db->prepare("SELECT * FROM menu");
                $select_stmt->execute();

                while ($row = $select_stmt->fetch(PDO::FETCH_ASSOC)) {
            ?>

                <tr>
                    <td><?php echo $row["name"]; ?></td>
                    <td><?php echo $row["img"]; ?></td>
                    <td><?php echo $row["info"]; ?></td>
                    <td><?php echo $row["step"]; ?></td>
                    <td><a href="editMenu.php?update_id=<?php echo $row["id"]; ?>" class="btn btn-warning">Edit</a></td>
                    <td><a href="?delete_id=<?php echo $row["id"]; ?>" class="btn btn-danger">Delete</a></td>
                </tr>

            <?php } ?>
        </tbody>
    </table>
    </div>
    
    

    <script src="js/slim.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>