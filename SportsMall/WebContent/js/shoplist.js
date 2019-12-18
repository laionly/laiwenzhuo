$(document).ready(function () {
	// 通过获取cookie进行操作-------------------------------
	if (getCookie('bskclick') == 111) {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'block')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
		clearCookie('bskclick')
	}
	if (getCookie('ftbclick') == 111) {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'block')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
		clearCookie('ftbclick')
	}
	if (getCookie('yumaoclick') == 111) {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'block')
		$('.box4').css('display', 'none')
		clearCookie('yumaoclick')
	}
	// ---------------------------------------------------

	$('#bsk').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'block')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
	})
	$('#ftb').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'block')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
	})
	$('#yumao').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'block')
		$('.box4').css('display', 'none')
	})
	$('#bingpang').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'block')
	})
	// 底部导航部分
	$('#bottom-bsk').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'block')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
	})
	$('#bottom-ftb').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'block')
		$('.box3').css('display', 'none')
		$('.box4').css('display', 'none')
	})
	$('#bottom-yumao').click(function () {
		$('.box').css('display', 'none')
		$('.box1').css('display', 'none')
		$('.box2').css('display', 'none')
		$('.box3').css('display', 'block')
		$('.box4').css('display', 'none')
	})
})