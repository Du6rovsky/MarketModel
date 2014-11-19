jQuery(function ($) {
	$(".m").keyup(function () {
		 var v1 = parseFloat($(this).val());
		 var v2 = parseFloat($(".k").val());
		 var v3 = 100 - (v1 + v2)
		 $(".w").val(v3);
	})
	$(".w").keyup(function () {
		 var v1 = parseFloat($(this).val());
		 var v2 = parseFloat($(".m").val());
		 var v3 = 100 - (v1 + v2)
		 $(".k").val(v3);
	})
	$(".k").keyup(function () {
		 var v1 = parseFloat($(this).val());
		 var v2 = parseFloat($(".w").val());
		 var v3 = 100 - (v1 + v2)
		 $(".m").val(v3);
	})
});