package dev.datlag.kommons


data object SaintLucia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LCA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(662)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1758)
}