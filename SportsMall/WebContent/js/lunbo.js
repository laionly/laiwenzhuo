
        $(document).ready(function () {
            var i = 0

            function lunbo() {
                // .img img即轮播的图片
                $('.img img').eq(i).css('display', 'none')
                $('#divbottom_u li').css({  //#divbottom_u li底部的五个小按钮
                    'color': 'black',
                    'background': 'gold'
                });
                i++;
                i === 5 && (i = 0);
                $('.img img').eq(i).css('display', 'block')
                $('#divbottom_u li').eq(i).css({
                    'color': 'black',
                    'background': 'white'
                })
            }
            var time = setInterval(lunbo, 2000);

            // 鼠标移入移出轮播包裹层事件
            $('.lunbowrap').hover(function () {
                clearInterval(time);
                $('.divbottom').css('display', 'block') //.divbottom 搭载轮播图上的左右箭头
            }, function () {
                time = setInterval(lunbo, 1000);
                $('.divbottom').css('display', 'none')
            })

            // 左箭头的点击事件
            $('#span1').click(function () {
                $('.img img').eq(i).css('display', 'none')// .img img即轮播的图片
                $(' #divbottom_u li').eq(i).css({//#divbottom_u li底部的五个小按钮
                    'color': 'black',
                    'background': 'gold'
                })
                i--
                i === -1 && (i = 4)
                $('.img img').eq(i).css('display', 'block')
                $('#divbottom_u li').eq(i).css({
                    'color': 'black',
                    'background': 'white'
                });
            })
            // 右箭头的点击事件
            $('#span2').click(function () {
                lunbo()
            })

            //#divbottom_u li底部五个小按钮的点击事件
            $('#divbottom_u li').click(function() {
                $('.img img').css('display','none')
                $('#divbottom_u li').css({
                    'color': 'black',
                    'background': 'gold'
                })
                i = $(this).index();
                $(' #divbottom_u li').eq(i).css({
                    'color': 'black',
                    'background': 'white'
                })
                $('.img img').eq(i).css('display', 'block')// .img img即轮播的图片
            })

            $('img').click(function(){
                window.location.href='shoplist.html'
            })
        })
  