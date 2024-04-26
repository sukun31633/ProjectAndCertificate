<?php 
    require_once('connection.php');

    if (isset($_REQUEST['btn_insert'])) {
        $name = $_REQUEST['txt_name'];
        $img = $_REQUEST['txt_img'];
        $info = $_REQUEST['txt_info'];

        if (empty($name)) {
            $errorMsg = "please Enter Name";
        }else if (empty($img)) {
            $errorMsg = "please Enter Image";
        }else if (empty($info)) {
            $errorMsg = "please Enter Description";
        }else {
            try {
                if (!isset($errorMsg)) {
                    $insert_stmt = $db->prepare("INSERT INTO data (name,img,info) VALUES (:mangoname, :mangoimg, :mangoinfo)");
                    $insert_stmt->bindParam(':mangoname', $name);
                    $insert_stmt->bindParam(':mangoimg', $img);
                    $insert_stmt->bindParam(':mangoinfo', $info);
                    

                    if ($insert_stmt->execute()) {
                        $insertMsg = "Insert Successfully...";
                        //header("refresh:2;indexLink.php");
                    }
                }
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="bootstrap/bootstrap.css">
</head>
<body>

    <div class="container">
    <div class="display-3 text-center">Add Data</div>

    <?php 
         if (isset($errorMsg)) {
    ?>
        <div class="alert alert-danger">
            <strong>Wrong! <?php echo $errorMsg; ?></strong>
        </div>
    <?php } ?>
    

    <?php 
         if (isset($insertMsg)) {
    ?>
        <div class="alert alert-success">
            <strong>Success! <?php echo $insertMsg; ?></strong>
        </div>
    <?php } ?>

    <form method="post" class="form-horizontal mt-5">

            <div class="form-group text-center">
                <div class="row">
                    <label for="name" class="col-sm-3 control-label">Name Data</label>
                    <div class="col-sm-9">
                        <input type="text" name="txt_name" class="form-control" placeholder="Enter Data...">
                    </div>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="row">
                    <label for="img" class="col-sm-3 control-label">Image</label>
                    <div class="col-sm-9">
                        <input type="text" name="txt_img" class="form-control" placeholder="Enter Image...">
                    </div>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="row">
                    <label for="info" class="col-sm-3 control-label">Description</label>
                    <div class="col-sm-9">
                        <input type="text" name="txt_info" class="form-control" placeholder="Enter Description...">
                    </div>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-md-12 mt-3">
                    <input type="submit" name="btn_insert" class="btn btn-success" value="Insert">
                    <a href="indexData.php" class="btn btn-danger">Cancel</a>
                </div>
            </div>


    </form>

    <script src="js/slim.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>