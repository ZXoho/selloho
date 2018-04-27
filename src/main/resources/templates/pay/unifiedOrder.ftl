<script>
    wx.requestPayment(
            {
                'timeStamp': '${timeStamp}',
                'nonceStr': '${nonceStr}',
                'package': '${orderResult.prepayId}',
                'signType': 'MD5',
                'paySign': '',
                'success':function(res){},
                'fail':function(res){},
                'complete':function(res){}
            })
</script>