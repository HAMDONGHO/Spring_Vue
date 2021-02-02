<template>
    <header>
        <h1>
            <a href="#" class="logo"><img alt="Vue logo" src="../../assets/logo.png" width="80"></a>
            <div class="menuWrap">
                <ul class="menu">
                    <!--router-link로 매핑-->
                    <li><router-link to="/board/list">게시판</router-link></li>
                    <li><a href="javascript:;">메뉴2</a></li>
                    <li><a href="javascript:;">메뉴3</a></li>
                    <li><a href="javascript:;">메뉴4</a></li>
                </ul>
            </div>
        </h1>
    </header>
</template>

<script>
export default {
    
}
</script>

<style scoped>
header{width:100%; text-align:center; position:relative; height:10px; border-bottom:1px solid #35495e}
header h1{position:absolute; top:0px; left:100px;}
header ul.menu:after{display:block; clear:both; content:'';}
header ul.menu{position:absolute; top:20px; right:50px;}
header ul.menu li{float:center; padding:10px 20px; list-style:none; font-size: 15pt;}

a{text-decoration:none; color:#333;}
</style>