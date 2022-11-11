package main

import (
	"context"
	"fmt"
	"net"
)

//import (
//	"code.byted.org/middleware/hertz/pkg/app
//	"code.byted.org/middleware/hertz/pkg/app/server
//	"context"
//)
//
//func main() {
//	h := server.New()
//	h.POST("/sis",func(c context.Context, ctx *app.RequestContext) {
//		ctx. Data(200,"text/plain; charset=utf-8", []byte( "OK" ))
//	})
//	h.Spin()
//}

func main() {
	var a = 2
	var b = 3
	result := calculate(a, b)
	fmt.Println(result)
	return
}
func calculate(x, y int) {
	z := x * y
	return z
}
