package dev.datlag.kommons


data object Liberia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LBR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(430)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(231)
}