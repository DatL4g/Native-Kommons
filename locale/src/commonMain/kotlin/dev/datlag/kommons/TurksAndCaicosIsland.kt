package dev.datlag.kommons


data object TurksAndCaicosIsland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TCA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(796)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1649)
}