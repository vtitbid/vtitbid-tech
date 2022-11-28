config.module.rules.push(
    {
        test: /\.s[ac]ss$/i,
        use: [
            "style-loader",
            "css-loader",
            "sass-loader"
        ]
    }
)

config.resolve.alias = {
    '/images/spinners': false,
    '/images/modules': false
}