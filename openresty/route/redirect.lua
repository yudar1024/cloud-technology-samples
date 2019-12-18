--请求头
local args = ngx.req.get_uri_args()
-- 此处userid 应该要放在header里，而且需要进行hash，而不是直接使用，此处仅仅因为方便测试所以简写了逻辑。
local index = args.userid % 3
if index == 0 then
  -- 定位到后端某个服务statful-index 这里用百度模拟
  -- ngx.var.upstream_server = "https://www.baidu.com"
  return ngx.exec("/163")
elseif index == 1 then
  -- ngx.var.upstream_server = "https://www.163.com"
  return ngx.exec("/baidu")
elseif index ==2 then
  ngx.var.upstream_server = "127.0.0.1"
  return ngx.exec("@client.new")
end
